package comm;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BaseDao {
	private static Evn evn = Evn.getInstancEvn();
	private static String DRIVER = evn.getProperty("driver");
	private static String URL = evn.getProperty("url");
	private static String USERNAME = evn.getProperty("user");
	private static String PASSWORD = evn.getProperty("password");

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	// 1.注册驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 2.连接服务器
	public void getConnection() throws SQLException {
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	// 3.添加，删除，更新
	public int executeUpdate(String sql, Object[] o) {
		int row = 0;
		try {
			// 连接数据库
			getConnection();
			// 执行
			ps = conn.prepareStatement(sql);
			// 给sql语句赋值ֵ
			if (o != null && o.length > 0) {
				for (int i = 0; i < o.length; i++) {
					ps.setObject(i + 1, o[i]);
				}
			}
			row = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭
			free(null, ps, conn);
		}
		return row;
	}

	// 4.查询

	public List executeQuery(String sql, Object[] o, Class cls) {
		List<Object> list = new ArrayList<Object>();
		try {
			getConnection();
			ps = conn.prepareStatement(sql);
			if (o != null && o.length > 0) {
				for (int i = 0; i < o.length; i++) {
					ps.setObject(i + 1, o[i]);
				}
			}
			rs = ps.executeQuery();
			// 获取类的属性，存放在数组中
			Field[] fields = cls.getDeclaredFields();
			while (rs.next()) {
				// 创建object对象
				Object obj = cls.newInstance();
				// 获得属性ֵ
				for (int i = 0; i < fields.length; i++) {
					Field f = fields[i];
					f.setAccessible(true);
					// getType获取数据类型
					String type = f.getType().getName();
					if (type.equals("int")) {
						f.set(obj, rs.getInt(i + 1));
					} else if (type.equals("java.lang.String")) {
						f.set(obj, rs.getString(i + 1));
					} else if (type.equals("double")) {
						f.set(obj, rs.getDouble(i + 1));
					}
				}
				// 将对象添加到集合中
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			free(rs, ps, conn);
		}
		return list;
	}
	// 5.关闭
	public void free(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

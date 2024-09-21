package vn.iotstar.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.configs.DBConnectMySQL;

import vn.iotstar.dao.IUserDao;
import vn.iotstar.models. UserModel;

public class UserDaoImpl extends DBConnectMySQL implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public List<UserModel> FindAll() throws ClassNotFoundException {
        /*
        String sqlQuery = "Select * from users";
        List<UserModel> list = new ArrayList<>();
        try{
            conn = super.getDatabaseConnection();
            ps = conn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("fullname"), rs.getString("images"))); //Add vào
            }
            return list;
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }

         */
        String sql = "SELECT * FROM login ";
        try {
            List<UserModel> list = new ArrayList<>();
            new DBConnectMySQL();
			conn = DBConnectMySQL.getDatabaseConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("fullname"),
                        rs.getString("password"),
                        rs.getString("avatar"),
                        rs.getString("email"),
                        rs.getInt("roleid"),
                        rs.getString("phone"),
                        rs.getDate("createDate")));
            }
            return list;
        } catch (Exception e) {e.printStackTrace(); }
        return null;
    }

    @Override
    public UserModel FindById(int id) {
        return null;
    }

	@Override
	public void Insert(UserModel user) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel FindByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String username, String newPassword) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserModel FindByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}  
    
}
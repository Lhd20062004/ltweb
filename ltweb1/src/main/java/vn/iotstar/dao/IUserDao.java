package vn.iotstar.dao;
import java.sql.SQLException;
import java.util.List;
import vn.iotstar.models.UserModel;
public interface IUserDao {
    List<UserModel> FindAll() throws ClassNotFoundException;
    UserModel FindById(int id);
    void Insert(UserModel user) throws SQLException, ClassNotFoundException;
    UserModel FindByUsername(String username);
    void updatePassword(String username, String newPassword) throws SQLException;
    UserModel FindByEmail(String email);
}
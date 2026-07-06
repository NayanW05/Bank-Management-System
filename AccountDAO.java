package bank;
import java.sql.*;
import java.util.*;
import bank.MainApp;

public class AccountDAO {
    public static void openAccount(int custId){
        try(Connection con = DBConnection.getConnection(); Scanner sc=new Scanner(System.in)){
            System.out.print("Account Type ID: ");
            int type = MainApp.sc.nextInt();
            System.out.print("Initial Deposit: ");
            double amt = MainApp.sc.nextDouble();

            CallableStatement cs = con.prepareCall("{CALL open_new_account(?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1,custId);
            cs.setString(2,null);
            cs.setString(3,null);
            cs.setString(4,null);
            cs.setString(5,null);
            cs.setString(6,null);
            cs.setDate(7,null);
            cs.setInt(8,type);
            cs.setDouble(9,amt);
            cs.registerOutParameter(10,java.sql.Types.INTEGER);
            cs.execute();

            System.out.println("New Account Number: "+cs.getInt(10));
        } catch(Exception e){ System.out.println(e); }
    }
}


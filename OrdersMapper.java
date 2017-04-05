package com.Mapper;

import com.DB.DBConnector;
import com.Entity.Orders;
import java.io.EOFException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrdersMapper {

    Connection conn = new DBConnector().getConnection();

    public Orders getOrders(int ono) throws SQLException {

        Orders o = null;
         
        try {
            
            String sql = "SELECT * FROM `Orders` WHERE ono = ?";         
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, ono);
            ResultSet rs = pstmt.executeQuery();

            //System.out.println(pstmt);
         
            if (rs.next()){
                
                o = new Orders();
                
                o.setOno(rs.getInt("ono"));
                o.setEid(rs.getInt("FK_employeeid"));
                o.setCid(rs.getInt("FK_customerid"));               
                o.setWname(rs.getString("FK_wname"));
                o.setSname(rs.getString("FK_sname"));
                o.setRname(rs.getString("FK_rname"));
                
                return o;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return o;

    }
    
     public ArrayList<Orders> getAllOrder() throws SQLException
    {
         Orders ListOrder = null;
        ArrayList<Orders> allOrder = new ArrayList<>();
        try {
            Connection conn = new DBConnector().getConnection();
            String sql = "SELECT * FROM Orders";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) 
            {
                int Order_id = rs.getInt("ono");
                int fk_employee = rs.getInt("FK_employeeid");
                int fk_customer = rs.getInt("FK_customerid");
                String fk_wood = rs.getString("FK_wname");
                String fk_screw = rs.getString("FK_sname");
                String fk_roof = rs.getString("FK_rname");
                ListOrder = new Orders(Order_id, fk_employee, fk_customer, fk_wood, fk_screw, fk_roof);
                allOrder.add(ListOrder);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        
        return allOrder;
    }
    
    public static void main(String[] args) throws SQLException {

        Orders o = new OrdersMapper().getOrders(12);
        System.out.println(o);
    }

    public Orders getOrders(Orders o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

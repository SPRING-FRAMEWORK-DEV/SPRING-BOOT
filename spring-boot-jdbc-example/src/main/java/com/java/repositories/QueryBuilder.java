package com.java.repositories;

public class QueryBuilder {
public static final String INSERT_VEHICLE="INSERT INTO TBL_VEHICLE(V_TYPE,V_REGNO,V_OWNER,V_MDATE) VALUES(:vType,:vRegNo,:vOwner,:vManfactureDate)";
public static final String UPDATE_VEHICLE="UPDATE TBL_VEHICLE SET V_TYPE=:vType,V_REGNO=:vRegNo,V_OWNER=:vOwner,V_MDATE=:vManfactureDate WHERE V_ID=:vId";
public static final String DELETE_VEHICLE="DELETE FROM TBL_VEHICLE WHERE V_ID=:vId";

}

package com.courses.subd.dao;//package com.courses.subd.dao;
//
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
//
//public class StudentDaoJdbc implements StudentDao{
//    private final NamedParameterJdbcOperations jdbc;
//
//    public StudentDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {this.jdbc = jdbcOperations;}
//
//    @Override
//    public int count() {
//        return jdbc.getJdbcOperations()
//                .queryForObject("select count(*) from students", Integer.class);
//    }
//
//    @Override
//    public void insert(Student student){
//
//    }
//
//}

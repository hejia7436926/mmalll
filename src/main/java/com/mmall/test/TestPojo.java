package com.mmall.test;

/**
 * @version : 1.0
 * @ClassName: TestPojo
 * @Description :
 * @auther: hejia
 * @date: 2019/3/21
 */
public class TestPojo {

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

//    @Override
//    public int hashCode() {
//        return id.hashCode() * name.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if(obj == null){
//            return false;
//        }
//        if(this == obj){
//            return true;
//        }
//        if(obj instanceof TestPojo){
//            TestPojo t = (TestPojo) obj;
//            //比较两个属性的值，一致才返回true
//            if(t.id.equals(this.id) && t.name.equals(this.name)){
//                return true;
//            }
//
//        }
//        return false;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {return false;}

        TestPojo testPojo = (TestPojo) o;

        if (id != null ? !id.equals(testPojo.id) : testPojo.id != null) {return false;}
        return name != null ? name.equals(testPojo.name) : testPojo.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

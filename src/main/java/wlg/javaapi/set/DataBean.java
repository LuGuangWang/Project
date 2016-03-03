/**
 * 
 */
package wlg.javaapi.set;

/**
 * @author wangluguang
 *
 */
public class DataBean {
	private String name;
	private String value;
	
	DataBean(String name,String value){
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public String toString(){
		return name+":"+value;
	}
	/**
	 * 	重写equals方法的要求：
	 *	1.自反性：对于任何非空引用x，x.equals(x)应该返回true。
	 *	2.对称性：对于任何引用x和y，如果x.equals(y)返回true，那么y.equals(x)也应该返回true。
	 *	3.传递性：对于任何引用x、y和z，如果x.equals(y)返回true，y.equals(z)返回true，那么x.equals(z)也应该返回true。
	 *	4.一致性：如果x和y引用的对象没有发生变化，那么反复调用x.equals(y)应该返回同样的结果。
	 *	5.非空性：对于任意非空引用x，x.equals(null)应该返回false。
	 */
    public boolean equals(Object obj) {  
        if(this == obj)  
            return false;  
        if(obj == null)  
            return false;  
        if(getClass() != obj.getClass() )  
            return false;  
        DataBean other = (DataBean)obj;  
        if(name == null) {  
             if(other.name != null) {  
                  return false;  
             }  
        }else if(!name.equals(other.name))  
             return false;
        return true;  
    }
    
    public int hashCode(){
    	return this.name.hashCode();
    }
}

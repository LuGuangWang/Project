/**
 * 
 */
package wlg.javaapi.lambda;

/**
 * 泛型接口
 * @author Administrator
 *
 */
public interface Filter<T> {
	boolean test(T t);
}

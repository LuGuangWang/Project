package wlg.javaapi.demo.adapter;

/*
 * 适配器类
 * 以下情况比较适合使用 Adapter 模式：
 * 1.当你想使用一个已经存在的类，而它的接口不符合你的需求；
 * 2.你想创建一个可以复用的类，该类可以与其他不相关的类或不可预见的类协同工作；
 * 3.你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口，对象适配器可以适配它的父亲接口。
 */
public class Adapter implements Target{
	 /*
	 * 持有需要被适配的接口对象
	 */
	private Adaptee adaptee;
	/*
	 * 构造方法，传入需要被适配的对象
	 * @param adaptee 需要被适配的对象
	 */
	public Adapter(Adaptee adaptee){
	this.adaptee = adaptee;
	}
	@Override
	public void request() {
		// TODO Auto-generated method stub
		adaptee.specificRequest();
	}
 
}

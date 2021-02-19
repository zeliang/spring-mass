package com.lzl.spring.server.effect.refer;


import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class JavaReferType {

	/***
	 * 对象强引用
	 */

	public void strongReference() {
		// 强引用 objRef
		Object objRef = new Object();
		// 强引用 stongRef
		Object stongRef = objRef;

		// objRef引用指向null，但是还有一个强引用stongRef指向这个对象，所以这个对象不会被回收
		objRef = null;
		System.gc();

	}

	/**
	 * 弱引用
	 */
	public void weakReference() {
		Object referent = new Object();
		// 弱引用，只有当一个对象都没有被强引用所指向时候，这个时候gc，由一个对象的强应用所包装的对应弱引用就会被回收
		WeakReference<Object> weakRerference = new WeakReference<Object>(referent);
		// 把对象的唯一强引用指向null，这个时候gc，对应的弱引用就会指向null，被回收了
		referent = null;
		System.gc();

		// 一旦Object referent 这个强应用被指向了null，那么gc后weakRerference.get()这个也会被回收了
	}


	public void softReference() {
		// 强引用
		Object ref1 = new Object();
		// 软引用和弱引用的区别就是，软引用和弱引用类似，但是控制是否gc后回收，只有在jvm内存不够时候才会进行回收
		SoftReference<Object> softRef = new SoftReference<Object>(ref1);
		// 强引用被指向null
		ref1 = null;
		System.gc();

		// 这个时候，软引用不会被回收，因为还有大把内存，不需要回收这个对象
	}

}

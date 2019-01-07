package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
	
	public HelloServlet(){
		System.out.println("HelloServlet's constructor...");
	}

	@Override
	/**
	 * servlet容器在收到请求之后,会调用servlet的
	 * service方法来处理请求
	 * 注:
	 *    容器会将request对象和response对象实现创建好,然后
	 *   作为参数传递给service方法
	 *    容器会将请求数据包中的数据解析出来然后存放到request
	 *   对象上,开发人员只需要调用request对象提供的方法就
	 *   可以获得请求数据包中所有数据(比如获得请求参数值).
	 *    另外,开发人员只需要将处理结果存放到request
	 *   对象上即可,容器会从response对象上获得处理结果,然后
	 *   创建响应数据包并发给浏览器.
	 */
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		System.out.println("HelloServlet's service...");
		
		//Integer.parseInt("123 ");
		/*
		 * 通过request对象获得请求参数值.
		 * 注意:
		 *   如果请求参数名与实际传递过来的请求参数名
		 *   不一样,会得到null值
		 */
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		
		
		
		
		/*
		 * 设置响应类型(即设置content-Type消息头)
		 * 注:
		 *  通过设计响应类型,可以告诉浏览器,
		 * 服务器返回的数据类型,浏览器会采取相应的
		 * 方式来解析服务器返回的数据
		 * 
		 */
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		/*
		 * out.println方法只是将数据存放到了response
		 * 对象里面.
		 */
		out.println("<h1>Hello "+name+"</h1>");
		/*
		 * 关闭流:
		 * 注:
		 *  不用调用close方法也可以,容器会自动关闭流.
		 */
		out.close();
		
	}
	
}

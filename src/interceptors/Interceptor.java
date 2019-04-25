package interceptors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cn.domain.User;

public class Interceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2, ModelAndView arg3) throws Exception {
	
		HttpSession session = req.getSession(true);  
        // 从session 里面获取用户名的信息  
        Object obj = session.getAttribute("user");  
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆  
        if (obj == null || "".equals(obj.toString())) {
        	ServletContext context = req.getSession().getServletContext();
        	// req.getRequestDispatcher("/login.jsp").forward(req, res);
            res.sendRedirect("login.jsp");  
		
       
       
	}
	}
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		/*HttpSession session = req.getSession(true);  
        // 从session 里面获取用户名的信息  
        Object obj = session.getAttribute("user");  
        // 判断如果没有取到用户信息，就跳转到登陆页面，提示用户进行登陆  
        if (obj == null || "".equals(obj.toString())) {
        	ServletContext context = req.getSession().getServletContext();
        	 req.getRequestDispatcher("/login.jsp").forward(req, res);
            //res.sendRedirect("login.do");  
		
         return false;
       
	}*/

        return true;  
	
}

	
	
}

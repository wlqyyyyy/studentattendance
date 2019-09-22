package filter;
/**
 * ���ع���
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public class LoginFilter implements Filter {

		@Override
		public void destroy() {
			// TODO Auto-generated method stub

		}

		@Override
	 public void doFilter(ServletRequest req, ServletResponse rep,
				FilterChain chain) throws IOException, ServletException {
			// TODO Auto-generated method stub
			Object user;
			HttpServletRequest request = (HttpServletRequest)req;
			HttpServletResponse response = (HttpServletResponse)rep;
			user = request.getSession().getAttribute("user");
			if(user == null){
				//δ��¼
				response.sendRedirect("index.jsp");
				return;
			}else{
				chain.doFilter(request, response);
			}
		}

		@Override
		public void init(FilterConfig arg0) throws ServletException {
			// TODO Auto-generated method stub

		}

	}


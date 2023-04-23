package k23op1.op1_backend.web;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {
	
	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		
        // Virhestatuksen selvittäminen
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		if (status != null) {
			int statusCode = Integer.parseInt(status.toString());
			
			// Näyttää 404-sivun
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				return "404";
			} 
			
		}
		return "error";
	}

}

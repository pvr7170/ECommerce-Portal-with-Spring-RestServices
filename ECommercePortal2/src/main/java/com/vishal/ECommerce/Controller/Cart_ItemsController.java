package com.vishal.ECommerce.Controller;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.HttpHeaders;
import com.vishal.ECommerce.Model.OrdersModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Service.Cart_ItemsService;
import com.vishal.ECommerce.Service.UserService;
import ch.qos.logback.core.net.SyslogOutputStream;

@RestController
public class Cart_ItemsController {

	
	
	
}

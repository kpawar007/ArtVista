		package com.artapp.controller;
		
		import java.util.List;
		
		import org.springframework.beans.factory.annotation.Autowired;
		import org.springframework.stereotype.Controller;
		import org.springframework.web.bind.annotation.GetMapping;
		import org.springframework.web.bind.annotation.PostMapping;
		import org.springframework.web.bind.annotation.RequestBody;
		import org.springframework.web.bind.annotation.RequestParam;
		import org.springframework.web.servlet.ModelAndView;
		
		import com.artapp.model.Art;
		import com.artapp.model.Cart;
		import com.artapp.model.CartUpdate;
		import com.artapp.repository.CartRepository;
		import com.artapp.service.ArtService;
		import com.artapp.service.CartServices;
	
	import jakarta.servlet.http.HttpSession;
		
		@Controller
		public class CartController {
			
			@Autowired
			private CartServices cartservice;
			
			@Autowired
			private ArtService artservice;
			
			@Autowired
			private CartRepository crepo;
			
			
			@GetMapping("/addtocart")
			public String showAddCart(@RequestParam("artId") int artId, HttpSession session) {
				
				String emailId = (String) session.getAttribute("customerEmailID");
				
				Art art = artservice.getArtById(artId);
				Cart c = new Cart();
				c.setQuantity(1);
				double totalprice=art.getPrice()*1;
				c.setTotalPrice(totalprice);
				System.out.println(c.getTotalPrice());
				c.setArt(art);
				c.setEmail(emailId);
				cartservice.addCart(c);
				
				return "redirect:/cartList";
			}
			
			@GetMapping("/cartList")
			public ModelAndView showCart(String emailId, HttpSession session)
			{
				emailId = (String) session.getAttribute("customerEmailID");
				List<Cart> cartList=crepo.findByEmail(emailId);
				return new ModelAndView("CartList", "clist", cartList);
			}
			
			@PostMapping("/updateCart")
			public String updateCart(@RequestBody CartUpdate up) {
				
				int cid = up.getCid();
				System.out.println("Cid"+cid);
					int quantity = up.getQuantity();
					System.out.println("quantity"+quantity);
					double totalPrice = up.getTotalPrice();
					System.out.println("total price"+totalPrice);
					
				Cart c = crepo.findById(cid).get();
				c.setCartId(cid);
				c.setQuantity(quantity);
				System.out.println("New Quabtity "+quantity);
				c.setTotalPrice(totalPrice);
				cartservice.addCart(c);
				
				return "/cartList";	
			}
			
			@GetMapping("/deletecart")
			public String deleteCart(@RequestParam("cartId") int cartId) {
				cartservice.deleteCartById(cartId);
				return "/cartList";
			}
			
		}

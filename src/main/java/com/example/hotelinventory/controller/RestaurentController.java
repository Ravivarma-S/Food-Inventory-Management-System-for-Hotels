package com.example.hotelinventory.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.hotelinventory.dto.RestaurentDTO;
import com.example.hotelinventory.dto.StocksDTO;
import com.example.hotelinventory.model.IngredientEntity;
import com.example.hotelinventory.model.RecipeEntity;
import com.example.hotelinventory.model.RestaurentEntity;
import com.example.hotelinventory.model.StocksEntity;
import com.example.hotelinventory.repository.IngredientRepository;
import com.example.hotelinventory.repository.RecipeRepository;
import com.example.hotelinventory.repository.StocksRepository;
import com.example.hotelinventory.service.RecipeService;
import com.example.hotelinventory.service.RestaurentService;
import jakarta.servlet.http.HttpSession;





@Controller
public class RestaurentController {
	
	private final RestaurentService restaurentService;
	
	 public RestaurentController(RestaurentService restaurentService) {
	        this.restaurentService = restaurentService;
	    }
	
	
	   @GetMapping("/restaurentregister")
	    public String restaurentRegister() {
	        return "register";
	    }
	   
	   @PostMapping("/savehotelregister")
	    public String saveRestaurent(RestaurentDTO dto) {
		   restaurentService.saveRestaurent(dto);
	       
	        return "login";
	    }
	   
	   @GetMapping("/restaurentlogin")
	    public String restaurentLogin() {
	        return "login";
	    }
	   
	   @PostMapping("/accesslogin")
	    public String restaurentLoginn(@RequestParam("email") String email,
               @RequestParam("password") String password, Model model, HttpSession session) {
		  
		  RestaurentEntity restaurent = restaurentService.validateRestaurentLogin(email, password);

		  
	       
		  if (restaurent != null) {
		        model.addAttribute("restaurent", restaurent);
		        session.setAttribute("email", email);
		        
		        return "home";
		    } else {
		        model.addAttribute("error", "Invalid Email or Password");
		        return "login";
		    }
	    }
	   
	   
	   @GetMapping("/addstocks")
	    public String addStocks() {
	        return "addstocks";
	    }
	   
	   
	   
	   
	   @PostMapping("/savestocks")
	    public String saveStocks(StocksDTO dto) {
		   restaurentService.saveStocks(dto);
	       
	        return "addstocks";
	    }
	   
	   
	   
	   @GetMapping("/back")
	    public String backToHome() {
	        return "home";
	    }
	   
	   
	   @GetMapping("/viewstocks")
		  public String viewStocks(Model model) {
	    	 List<StocksEntity> stocks = restaurentService.getAllStocks();
	    	    model.addAttribute("stocks", stocks);
	    	    return "viewstocks";
		  }


	   @GetMapping("/edit/{id}")
	   public String editStock(@PathVariable Long id, Model model) {
	       StocksEntity stock = restaurentService.getStockById(id);
	       model.addAttribute("stock", stock);
	       return "editstock";
	   }

	   @GetMapping("/delete/{id}")
	   public String deleteStock(@PathVariable Long id) {
	       restaurentService.deleteStock(id);
	       return "redirect:/viewstocks";
	   }
	   
	   
	   @PostMapping("/updatestock")
	   public String updateStocks(StocksDTO dto) {
	       restaurentService.updateStocks(dto);
	       return "redirect:/viewstocks";
	   }
	   
	   
	   @GetMapping("/addincredients")
	    public String addIncredient() {
	        return "addincredients";
	    }
	   
	   @GetMapping("/billing")
	    public String addBilling() {
	        return "billing";
	    }

	    private RecipeService recipeService1;

	    @Controller
	    public class RecipeController {

	        @Autowired
	        private RecipeService recipeService;

	        @PostMapping("/saverecipe")
	        public String saveRecipe(
	                @RequestParam String dishName,
	                @RequestParam String preparationNotes,
	                @RequestParam("ingName[]") String[] ingName,
	                @RequestParam("ingUnit[]") String[] ingUnit,
	                @RequestParam("ingQty[]") double[] ingQty,
	                @RequestParam("ingNote[]") String[] ingNote) {

	            recipeService.saveRecipe(
	                    dishName,
	                    preparationNotes,
	                    ingName,
	                    ingUnit,
	                    ingQty,
	                    ingNote
	            );

	            return "redirect:/back";
	        }
	    }
	    
	    @Autowired
	    RecipeRepository recipeRepository;
	    
	    @Autowired
	    IngredientRepository  ingredientRepository;
	    
	    @Autowired 
	    StocksRepository stockRepository;
	    
	    @PostMapping("/saveBill")
	    public String saveBill(
	            @RequestParam("itemName[]") List<String> dishNames,
	            @RequestParam("itemQty[]") List<String> dishQtys) {

	        for (int i = 0; i < dishNames.size(); i++) {

	            String dishName = dishNames.get(i);
	            double orderedQty = Double.parseDouble(dishQtys.get(i));

	            // find recipe
	            RecipeEntity recipe = recipeRepository.findByDishName(dishName);

	            if (recipe != null) {

	                List<IngredientEntity> ingredients =
	                        ingredientRepository.findByRecipeId(recipe.getId());

	                for (IngredientEntity ing : ingredients) {

	                    String ingredientName = ing.getIngName();

	                    double ingredientQty = Double.parseDouble(ing.getIngQty());

	                    double totalRequired = ingredientQty * orderedQty;

	                    // find stock
	                    StocksEntity stock =
	                            stockRepository.findByProductName(ingredientName);

	                    if (stock != null) {

	                        // convert String → Double
	                        double currentStock =
	                                Double.parseDouble(stock.getQuantity());

	                        double updatedStock = currentStock - totalRequired;

	                        if (updatedStock < 0) {
	                            throw new RuntimeException(
	                                    "Stock not enough for " + ingredientName);
	                        }

	                        // convert Double → String
	                        stock.setQuantity(String.valueOf(updatedStock));

	                        stockRepository.save(stock);
	                    }
	                }
	            }
	        }

	        return "redirect:/billing";
	    }

	    
	   }

	

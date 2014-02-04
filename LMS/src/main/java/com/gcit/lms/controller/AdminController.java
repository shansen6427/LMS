package com.gcit.lms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcit.lms.entities.Author;
import com.gcit.lms.entities.Book;
import com.gcit.lms.entities.Publisher;
import com.gcit.lms.service.AdminService;

@Controller
public class AdminController {

	@RequestMapping(value = "/")
	public String index(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/adminMenu", method = RequestMethod.GET)
	public String adminMenu(Locale locale, Model model) {
		return "adminMenu";
	}

	@RequestMapping(value = "/librarianMenu", method = RequestMethod.GET)
	public String librarianMenu(Locale locale, Model model) {
		return "librarianMenu";
	}

	@RequestMapping(value = "/borrowerMenu", method = RequestMethod.GET)
	public String borrowerMenu(Locale locale, Model model) {
		return "borrowerMenu";
	}

	@RequestMapping(value = "/addAuthor", method = RequestMethod.GET)
	public String addAuthor(Locale locale, Model model) {
		
		Author author = new Author();
		model.addAttribute("auth", author);
		
		return "addAuthor";
	}

	@RequestMapping(value = "/editAuthor", method = RequestMethod.GET)
	public String editAuthor(Locale locale, Model model) {
		
		AdminService admService = new AdminService();
		try {
			List<Author> authorList = admService.getAllAuthors();
			model.addAttribute("authors", authorList);
		} catch(Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		return "editAuthor";
	}

	@RequestMapping(value = "/editThisAuthor", method = RequestMethod.GET)
	public String editThisAuthor(@RequestParam(value="authId") int authorId,
			Locale locale, Model model) {
		
		AdminService admService = new AdminService();
		try {
		} catch(Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		return "editThisAuthor";
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public String addBook(Locale locale, Model model) {
		
		AdminService admService = new AdminService();
		try {
			List<Author> authorList = admService.getAllAuthors();
			Map<Integer, String> authorMap = new HashMap<Integer, String>();
			for(Author a : authorList) {
				authorMap.put(a.getAuthorId(), a.getAuthorName());
			}
			
			List<Publisher> publisherList = admService.getAllPublishers();
			Map<Integer, String> publisherMap = new HashMap<Integer, String>();
			for(Publisher p : publisherList) {
				publisherMap.put(p.getPublisherId(), p.getPublisherName());
			}
			
			model.addAttribute("authorMap", authorMap);
			model.addAttribute("publisherMap", publisherMap);
			model.addAttribute("book", new Book());
		} catch(Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		
		return "addBook";
	}

	@RequestMapping(value = "/saveAuthor", method = RequestMethod.POST)
	public String saveAuthor(@ModelAttribute(value="auth") Author author,
			Locale locale, Model model) {
		
		try {
			AdminService admService = new AdminService();
			admService.insertUpdate(author);
		} catch(Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		
		model.addAttribute("result", "Author Added Succesfully!");
		return "adminMenu";
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute(value="book") Book book,
			Locale locale, Model model) {
		
//		System.out.println(book.getTitle());
//		System.out.println(book.getAuthor().getAuthorId());
//		System.out.println(book.getPublisher().getPublisherId());
		
		try {
			AdminService admService = new AdminService();
			admService.insertUpdate(book);
		} catch(Exception e) {
			model.addAttribute("message", e.getMessage());
			return "error";
		}
		
		model.addAttribute("result", "Book Added Succesfully!");
		return "adminMenu";
	}
}

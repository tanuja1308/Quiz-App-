package com.quizeapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quizeapp.dao.contactsavedao;
import com.quizeapp.entities.contactform;
import com.quizeapp.entities.qna;
import com.quizeapp.entities.qnaangular;
import com.quizeapp.entities.qnapython;
import com.quizeapp.entities.qnaspring;
import com.quizeapp.entities.qnasql;
import com.quizeapp.entities.qnaweb;
import com.quizeapp.service.quizeintr;

@Controller
public class maincontroller {

	List<qna> rec;
	List<qnasql> recs;
	List<qnapython> recp;
	List<qnaangular> raca;
	List<qnaspring> racsp;
	List<qnaweb> racw;
	
	@Autowired
	quizeintr qi;
	
	@Autowired
	contactsavedao cs;

	String flag="java";
	
	@GetMapping("/home")
	private String getHome() {
		System.out.println("Homee");
		return "home";
	}

	@GetMapping("/tests")
	private String getTests() {
		return "tests";
	}
	
	@GetMapping("/contact")
	private String contactus(Model m) {
		System.out.println(qi.sqlshowAll());

		return "cwu";
	}

	@PostMapping("/savecon")
	public String savecontact(contactform c) {
		
		this.cs.save(c);
		return "home";
	}
	
	@GetMapping("/tests/javatest")
	private String getjavaRecords(Model m) {
		
		System.out.println(qi.javashowAll());
		List<qna> rec = (List<qna>) this.qi.javashowAll();

		m.addAttribute("r", rec);

		return "javatest";
	}
	@GetMapping("/tests/springtest")
	private String getspringRecords(Model m) {
		System.out.println(qi.springshowAll());
		List<qnaspring> rec = (List<qnaspring>) this.qi.springshowAll();
		flag="spring";

		m.addAttribute("r", rec);

		return "javatest";
	}
	@GetMapping("/tests/angulartest")
	private String getangularRecords(Model m) {
		System.out.println(qi.angularshowAll());
		flag="angular";

		List<qnaangular> rec = (List<qnaangular>) this.qi.angularshowAll();

		m.addAttribute("r", rec);

		return "javatest";
	}
	@GetMapping("/tests/webdevtest")
	private String getwebRecords(Model m) {
		System.out.println(qi.webshowAll());
		List<qnaweb> rec = (List<qnaweb>) this.qi.webshowAll();
		flag="web";

		m.addAttribute("r", rec);

		return "javatest";
	}
	@GetMapping("/tests/sqltest")
	private String getsqlRecords(Model m) {
		flag="sql";
		System.out.println(qi.sqlshowAll());
		List<qnasql> rec = (List<qnasql>) this.qi.sqlshowAll();

		m.addAttribute("r", rec);


		return "javatest";
	}
	
	
	@GetMapping("/tests/pythontest")
	private String getpythonRecords(Model m) {
		System.out.println(qi.pythonshowAll());
		List<qnapython> rec = (List<qnapython>) this.qi.pythonshowAll();
		flag="python";

		m.addAttribute("r", rec);

		return "javatest";
	}
	
	@RequestMapping(path = "tests/result", method = RequestMethod.POST)
	private String showMarks(@RequestParam(name = "answer_1", required = false) String a1,
			@RequestParam(name = "answer_2", required = false) String a2,
			@RequestParam(name = "answer_3", required = false) String a3,
			@RequestParam(name = "answer_4", required = false) String a4,
			@RequestParam(name = "answer_5", required = false) String a5,
			@RequestParam(name = "answer_6", required = false) String a6,
			@RequestParam(name = "answer_7", required = false) String a7,
			@RequestParam(name = "answer_8", required = false) String a8,
			@RequestParam(name = "answer_9", required = false) String a9,
			@RequestParam(name = "answer_10", required = false) String a10,Model model) {
		
		  ArrayList<String > a=new ArrayList<>(); a.add(a1); a.add(a2); a.add(a3);a.add(a4);
		  a.add(a5); a.add(a6); a.add(a7); a.add(a8); a.add(a9); a.add(a10);		 

		  int notans=0,ctr=0;
		  int mrk = 0,wans=0;

		  for(String s:a)
		  {
			  if(s==null)
			  {
				  notans++;
			  }
		  }

		  if(flag.equals("sql"))
		  {
			   recs = (List<qnasql>) this.qi.sqlshowAll();

			   for (qnasql q : recs) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					}
		  }
			   }
		  
		  else if(flag.equals("python"))
		  {
			  recp=(List<qnapython>) this.qi.pythonshowAll();
			   for (qnapython q : recp) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					}
		  }
			  
		  }
		  else if(flag.equals("web"))
		  {
			  racw=(List<qnaweb>) this.qi.webshowAll();
			   for (qnaweb q : racw) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					}		
		  }
			   }
		  else if(flag.equals("spring"))
		  {
			  racsp=(List<qnaspring>) this.qi.springshowAll();
			   for (qnaspring q : racsp) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					}
		  }
			   }
		  else if(flag.equals("angular"))
		  {
			  raca=(List<qnaangular>) this.qi.angularshowAll();
			   for (qnaangular q : raca) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					}
					}
		  }
		  else {
			   rec = (List<qna>) this.qi.javashowAll();

			   for (qna q : rec) {
					
					if (q.getAns().equals(a1) && (q.getQuesId()==1)) {
						System.out.println("I am 1");
						mrk++;
					} 
					else if (q.getAns().equals(a2) && (q.getQuesId()==2)) {
						System.out.println("I am ans 2 dude");
						mrk++;
						ctr++;

					} else if (q.getAns().equals(a3) && (q.getQuesId()==3)) {
						System.out.println("I am ans 3 dude");
						mrk++;

					} else if (q.getAns().equals(a4) && (q.getQuesId()==4)) {
						System.out.println("I am ans 4 dude");
						mrk++;

					} else if (q.getAns().equals(a5) && (q.getQuesId()==5)) {
						System.out.println("I am ans 5 dude");
						mrk++;
					} else if (q.getAns().equals(a6) && (q.getQuesId()==6)) {
						System.out.println("I am ans 6 dude");
						mrk++;

					} else if (q.getAns().equals(a7) && (q.getQuesId()==7)) {
						System.out.println("I am ans 7 dude");
						mrk++;

					} else if (q.getAns().equals(a8) && (q.getQuesId()==8)) {
						System.out.println("I am ans 8 dude");
						mrk++;

					} else if (q.getAns().equals(a9) && (q.getQuesId()==9)) {
						System.out.println("I am ans 9 dude");
						mrk++;

					} else if (q.getAns().equals(a10) && (q.getQuesId()==10)) {
						System.out.println("I am ans 10 dude");
						mrk++;

					} else {
						wans++;
						System.out.println(q.getAns());
					
		  }
				}
			   }
	

		model.addAttribute("m", mrk);
		model.addAttribute("na",notans);
		model.addAttribute("wa",wans);
		
		System.out.println(ctr+"i amctr");
		return "result";
	}
			   }
		  

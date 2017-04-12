package gp;

import java.util.ArrayList;

public class Course {
	   private String title;
	   private String identifier;
	   private ArrayList<Work> exams;
	   private ArrayList<Work> quizzes;
	   private ArrayList<Work> projects;
	   private ArrayList<Work> assignments;
	   private ArrayList<Work> extra;
	   private double current_grade;
	   private double desire_grade;

	   public Course(String title, String identifier, double desire_grade) {
	       this.title = title;
	       this.identifier = identifier;
	       this.desire_grade = desire_grade;
	       exams = new ArrayList<Work>();
		   quizzes= new ArrayList<Work>();
		   projects= new ArrayList<Work>();
		   assignments= new ArrayList<Work>();
		   extra= new ArrayList<Work>();
	   }
	   
	   public ArrayList<Work> getExams(){
		   return exams;
	   }
	   public ArrayList<Work> getQuzs(){
		   return quizzes;
	   }
	   public ArrayList<Work> getProjs(){
		   return projects;
	   }
	   public ArrayList<Work> getAssigs(){
		   return assignments;
	   }
	   public ArrayList<Work> getExtra(){
		   return extra;
	   }
	   
	   
	   public void setTitle(String title) { this.title = title; }

	   public String getTitle() { return title; }

	   public void setIdentifier(String identifier) { this.identifier = identifier; }

	   public String getIdentifier() { return identifier; }

	   public void setDesire_grade(double grade) { this.desire_grade = grade; }

	   public double getDesire_grade() { return desire_grade; }

	   public void setCurrent_grade(double grade) { this.current_grade = grade; }

	   public double getCurrent_grade() { return current_grade; }

	   // check if the work element exists in the works data structure
	   private Work containsWork(ArrayList<Work> works, String title) {
	       for(Work w:works) {
	           if(w.getTitle().equals(title)) {
	               return w;
	           }
	       }
	       return null;
	   }

	   // add a work into the data structure depending on the categories
	   public boolean add(Work work) {
	       switch (work.getCategory()) {
	           case EXAM:
	               if(containsWork(exams,work.getTitle()) == null) {
	                   exams.add(work);
	                   return true;
	               }
	               break;
	           case ASSIGNMENT:
	               if(containsWork(assignments,work.getTitle()) == null) {
	                   assignments.add(work);
	                   return true;
	               }
	               break;
	           case QUIZ:
	               if(containsWork(quizzes,work.getTitle()) == null) {
	                   quizzes.add(work);
	                   return true;
	               }
	               break;
	           case PROJECT:
	               if(containsWork(projects,work.getTitle()) == null) {
	                   projects.add(work);
	                   return true;
	               }
	               break;
	           case EXTRA:
	               if(containsWork(extra,work.getTitle()) == null) {
	                   extra.add(work);
	                   return true;
	               }
	               break;
	           default:
	               break;
	       }
	       return false;
	   }

	   // remove helper function to iterate through the data structure and locate the position
	   private ArrayList<Work> removeWork(ArrayList<Work> works, String title) {
	       for(int i =0;i<works.size();i++){
	           if (works.get(i).getTitle().equals(title)){
	               works.remove(works.get(i));
	           }
	       }
	       return works;
	   }

	   // remove the item by the type of categories
	   public void remove(Work.Category work, String target){
	       switch (work){
	           case EXAM:
	               exams = removeWork(exams,target);
	               break;
	           case ASSIGNMENT:
	               assignments = removeWork(assignments,target);
	               break;
	           case QUIZ:
	               quizzes = removeWork(quizzes,target);
	               break;
	           case PROJECT:
	               projects = removeWork(projects,target);
	               break;
	           case EXTRA:
	               extra = removeWork(extra,target);
	               break;
	           default:
	               break;
	       }
	   }
	   public String toString(){
		   String out = "";
		    out+="	Assigs\n";
			for(Work work :this.getAssigs()){
				out+="			";
				out+=work;
				out+="\n";
			}
			out+="	Exams\n";
			for(Work work :this.getExams()){
				out+="			";
				out+=work;
				out+="\n";
			}
			out+="	Projs\n";
			for(Work work :this.getProjs()){
				out+="			";
				out+=work;
				out+="\n";
			}
			out+="	Quzs\n";
			for(Work work :this.getQuzs()){
				out+="			";
				out+=work;
				out+="\n";
			}
			out+="	Extras\n";
			for(Work work :this.getExtra()){
				out+="			";
				out+=work;
				out+="\n";
			}
			return out;
	   }
	}


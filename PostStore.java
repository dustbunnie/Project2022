package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;


	public class PostStore implements Serializable{
		private LinkedList<Post> PostList;
		private static PostStore instance = null;
		private static final long serialVersionUID = -3481068384809124451L;
		
		public PostStore() {
			

			PostList = new LinkedList<Post>();
			
			try {
				
			      File myObj = new File("PostListFile.ser");
			      if (myObj.createNewFile()) {
			        System.out.println("File created: " + myObj.getName());
			      } else {
			        System.out.println("File found.");
			        FileInputStream file = new FileInputStream("PostListFile.ser");
			        
			        ObjectInputStream in = new ObjectInputStream(new FileInputStream("PostListFile.ser"));
			        
			        LinkedList<Post> myPostList = (LinkedList<Post>)in.readObject();
			        for (int x=0; x<myPostList.size(); x++) {
			        	PostList.add(myPostList.get(x));
			        }
			        
			        in.close();
			        file.close();
			      }
			      
			      
			}catch(Exception e) {
				e.printStackTrace();
			} 
			
		}
		
		public void insertPost(Post newpost) {
			PostList.add(newpost);
			addToFile();
		}
		
		public void replacePost(int x, Post newpost) {
			PostList.set(x, newpost);
			addToFile();
		}
		

		
		
		public void addToFile() {
			try {
				 FileOutputStream file = new FileOutputStream("PostListFile.ser");
			     ObjectOutputStream out = new ObjectOutputStream(file);
			     
			     
			     out.writeObject(PostList);
			     out.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public LinkedList<Post> getList() {
			return PostList;
		}
		
		public Post getPost(int postindex) {
			return PostList.get(postindex);
		}
		


		
		
	}


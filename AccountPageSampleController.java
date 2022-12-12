package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.TreeSet;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AccountPageSampleController implements Initializable{
	@FXML
	private VBox PostHolder;
	@FXML
	private Label TwittlrLabel;
	@FXML
	private VBox UserInformation;
	@FXML
	private Label TwittlrLabel1;
	@FXML
	private VBox PostObject1;


	// Event Listener on ScrollPane.onMouseMoved
	@FXML
	public void TwittlerPageController(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button.onAction
	@FXML
	public void LogInEvent(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			
			UserStore Users= new UserStore();
			
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("AccountInfoSample.fxml"));
			
			HBox infoBox = (HBox)root.getChildren().get(0);
			
			
			ImageView ProfilePic = (ImageView)infoBox.getChildren().get(0);
			
			User myUser = new User (TwittlrPageController.usernameClicked ,null, null);
			User AccountUser = Users.getUser(myUser);
			
			if (AccountUser.profilePic!=null) {
				Image image = new Image(AccountUser.profilePic.getAbsolutePath());
				ProfilePic.setImage(image);
				infoBox.getChildren().set(0, ProfilePic);	
			}
			
			Label Username = (Label)infoBox.getChildren().get(1);
			
			Username.setText(AccountUser.username);
			infoBox.getChildren().set(1, Username);
			
			Label Email = (Label)infoBox.getChildren().get(2);
			
			Email.setText(AccountUser.email);
			infoBox.getChildren().set(2, Email);
			
			//root.getChildren().set(0, infoBox);
			
			//Bio
			
			TextArea Biography = (TextArea) root.getChildren().get(1);
			Biography.setText(AccountUser.biography);
			if (SampleController.currentUser.username.toString().compareTo(AccountUser.username.toString())!=0) {
				Biography.setEditable(false);
				root.getChildren().set(1, Biography);
				root.getChildren().remove(2);
				root.getChildren().set(0, infoBox);
			}
			else {
				infoBox.getChildren().remove(3);
				root.getChildren().set(0, infoBox);
			}
			
			
			UserInformation.getChildren().add(root);
			
			
			
			
			//Adding User's Posts
			
			PostStore posts = new PostStore();
			LinkedList<Post> PostList = posts.getList();
			
			UserStore users = new UserStore();
			
			for (int x=PostList.size()-1; x>=0; x--) {
				User PostUser = PostList.get(x).Author;
				String s1=PostUser.username.toString();
				String s2 = AccountUser.username.toString();
				if (s1.compareTo(s2)==0) {
				VBox root2 = (VBox)FXMLLoader.load(getClass().getResource("SampleOfAPost.fxml"));
				
				
				HBox usernameAndProfPic = (HBox)root2.getChildren().get(0);
				
				Label Newlabel = (Label) usernameAndProfPic.getChildren().get(1);
				Newlabel.setText(PostList.get(x).getAuthor().getUsername());
				usernameAndProfPic.getChildren().set(1, Newlabel);
				
				ImageView newPic = (ImageView)usernameAndProfPic.getChildren().get(0);
				if (users.getUser(PostList.get(x).getAuthor()).profilePic!=null) {
					Image profPic = new Image(AccountUser.profilePic.getAbsolutePath());
					newPic.setImage(profPic);
					usernameAndProfPic.getChildren().set(0, newPic);
					}
				
				root2.getChildren().set(0, usernameAndProfPic);
				
				TextArea newTextArea = (TextArea)root2.getChildren().get(1);
				newTextArea.setText(PostList.get(x).getText());
				root2.getChildren().set(1, newTextArea);
				
				ImageView newImage = (ImageView)root2.getChildren().get(2);
				
				if (PostList.get(x).image != null) {
				Image image = new Image(PostList.get(x).getImageName());
				
				newImage.setImage(image);
				root2.getChildren().set(2, newImage);
				
				HBox HboxArea = (HBox)root2.getChildren().get(3);
				Label indexLabel = (Label)HboxArea.getChildren().get(5);
				indexLabel.setText(Integer.toString(x));
				
				Label Time = (Label)HboxArea.getChildren().get(4);
				Time.setText(PostList.get(x).dateString);
				
				Label CommentCount = (Label)HboxArea.getChildren().get(1);
				CommentCount.setText(String.valueOf(PostList.get(x).CommentCount)+" Comments");
				
				Label LikeCount = (Label)HboxArea.getChildren().get(3);
				LikeCount.setText(String.valueOf(PostList.get(x).Likes)+" Likes");
				
				root2.getChildren().set(3, HboxArea);
				
				
				
				}
				else {

					root2.getChildren().remove(2);
					
					HBox HboxArea = (HBox)root2.getChildren().get(2);
					Label indexLabel = (Label)HboxArea.getChildren().get(5);
					indexLabel.setText(Integer.toString(x));
					
					Label Time = (Label)HboxArea.getChildren().get(4);
					Time.setText(PostList.get(x).dateString);
					
					Label CommentCount = (Label)HboxArea.getChildren().get(1);
					CommentCount.setText(String.valueOf(PostList.get(x).CommentCount)+" Comments");
					
					Label LikeCount = (Label)HboxArea.getChildren().get(3);
					LikeCount.setText(String.valueOf(PostList.get(x).Likes)+" Likes");
					
					root2.getChildren().set(2, HboxArea);
				}
				
				
				
				

				root2.setPadding(new Insets(30, 30, 30, 30));
				PostObject1.getChildren().add( root2);

				
			}
			}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}

		

	
	
	public void BackButton() {
		try {
			ScrollPane root2 = (ScrollPane)FXMLLoader.load(getClass().getResource("TwittlrPage.fxml"));
			PostHolder.getScene().setRoot(root2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Follow() {
		AccountInfoSampleController a = new AccountInfoSampleController();
		a.Follow();

	}
	
	

	
	
	
	}

package fr.isika.cda17.project3.presentation;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import fr.isika.cda17.project3.model.personManagement.accounts.EntityAccount;
import fr.isika.cda17.project3.repository.personManagement.accounts.EntityAccountDao;
import fr.isika.cda17.project3.utils.Utils;

@ManagedBean
@ViewScoped
public class FileUploadBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	EntityAccountDao entityAccountDao;
	
	private File savedFile;
	private Part newProfilePic;
	private String message;

	public Part getNewProfilePic() {
	    return newProfilePic;
	}

	public void setNewProfilePic(Part newProfilePic) {
	    this.newProfilePic = newProfilePic;
	}


	public String getMessage() {
	    return message;
	}

	public void setMessage(String message) {
	    this.message = message;
	}

	public String uploadFile() throws IOException {
	    boolean newProfilePicSuccess = false;

	    if (newProfilePic != null && newProfilePic.getSize() > 0) {
		String fileName = Utils.getFileNameFromPart(newProfilePic);

		/**
		 * destination where the file will be uploaded
		 */
		savedFile = new File("C:\\Users\\farah\\Desktop\\FormationIsika\\ProjetsEclipse\\ISIKA_Projet3\\src\\main\\webapp\\media\\uploads", fileName);

		 System.out.println("savedFile.toPath(): " + savedFile.toPath());

		try (InputStream input = newProfilePic.getInputStream()) {
		    Files.copy(input, savedFile.toPath());
		} catch (IOException e) {
		    e.printStackTrace();
		}

		newProfilePicSuccess = true;
	    }

	   
	    if (newProfilePicSuccess) {
		// System.out.println("File uploaded to : " + path);
		/**
		 * set the success message when the file upload is successful
		 */
		setMessage("File successfully uploaded");
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		Long id = Long.valueOf(session.getAttribute("id").toString());
		EntityAccount entityAccount = entityAccountDao.findById(id);
		entityAccount.setProfilePicturePath(savedFile.getName());
		entityAccountDao.update(entityAccount);
	    } else {
		/**
		 * set the error message when error occurs during the file upload
		 */
		setMessage("Error, select atleast one file!");
	    }

	    /**
	     * return to the same view
	     */
	    return null;
	}

    }


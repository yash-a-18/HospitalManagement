package config;
// Generated 16 Apr, 2020 9:48:31 PM by Hibernate Tools 4.3.1



/**
 * DoctorId generated by hbm2java
 */
public class DoctorId  implements java.io.Serializable {


     private int docId;
     private String docEmail;

    public DoctorId() {
    }

    public DoctorId(int docId, String docEmail) {
       this.docId = docId;
       this.docEmail = docEmail;
    }
   
    public int getDocId() {
        return this.docId;
    }
    
    public void setDocId(int docId) {
        this.docId = docId;
    }
    public String getDocEmail() {
        return this.docEmail;
    }
    
    public void setDocEmail(String docEmail) {
        this.docEmail = docEmail;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DoctorId) ) return false;
		 DoctorId castOther = ( DoctorId ) other; 
         
		 return (this.getDocId()==castOther.getDocId())
 && ( (this.getDocEmail()==castOther.getDocEmail()) || ( this.getDocEmail()!=null && castOther.getDocEmail()!=null && this.getDocEmail().equals(castOther.getDocEmail()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getDocId();
         result = 37 * result + ( getDocEmail() == null ? 0 : this.getDocEmail().hashCode() );
         return result;
   }   


}


public class Hospital {
    String patientId;
    String patientName;
    int age;
    String DoctorName;
    String specialist;

    public Hospital(String patientId,String patientName,int age,String DoctorName, String specialist){
    this.patientId=patientId;
    this.patientName=patientName;
    this.age=age;
    this.DoctorName=DoctorName;
    this.specialist=specialist;

    }
    public String getPatientId(){
        return this.patientId;

    }
    public String getPatientName(){
        return this.patientName;

    }
    public int getAge(){
        return this.age;
    }
    public String getDoctorName(){
        return this.DoctorName;
    }
    public String getSpecialist(){
        return this.specialist;
    }

    
}

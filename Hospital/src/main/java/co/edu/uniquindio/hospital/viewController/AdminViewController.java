package co.edu.uniquindio.hospital.viewController;

import co.edu.uniquindio.hospital.App;
import co.edu.uniquindio.hospital.controller.HospitalController;

public class AdminViewController {
    App app;
    HospitalController hospitalController;



    public void setApp(App app) {
        this.app = app;
    }

    public void setHospitalController(HospitalController hospitalController) {
        this.hospitalController = hospitalController;
    }
}

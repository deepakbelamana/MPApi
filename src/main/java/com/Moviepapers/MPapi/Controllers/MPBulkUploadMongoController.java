package com.Moviepapers.MPapi.Controllers;

import com.Moviepapers.MPapi.Repositories.MPCinematiceRepository;
import com.Moviepapers.MPapi.Repositories.MPPaperRepository;
import com.Moviepapers.MPapi.models.MPBulkUploadMongo;
import com.Moviepapers.MPapi.models.MPCinematic;
import com.Moviepapers.MPapi.models.MPPaper;
import com.Moviepapers.MPapi.services.MPBulkUploadMongoService;
import com.Moviepapers.MPapi.services.MPCinematicService;
import com.Moviepapers.MPapi.services.MPPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class MPBulkUploadMongoController {

    @Autowired
    MPPaperRepository MPPaperRepository;
    @Autowired
    MPCinematiceRepository MPCinematicRepository;

    @Autowired
    MPCinematicService MPCinematicService;

    @Autowired
    MPPaperService MPPaperService;
    private String ImageKitPath = "https://ik.imagekit.io/6g5vpl8al/";

    @Autowired
    MPBulkUploadMongoService MPBulkUploadMongoService;
    @PostMapping("/bulkUpload/imagePaths")
    public String insertImagePathBasedOnProductAndMovie(@RequestBody MPBulkUploadMongo bulkdataInfo) {
      return MPBulkUploadMongoService.insertImagePathBasedOnProductAndMovie(bulkdataInfo);
    }



    @PostMapping("/bulkDelete")
    public String bulkDeleteDocsBasedOnProductAndMovie(@RequestBody MPBulkUploadMongo bulkdataInfo)
    {
        try{

            if(bulkdataInfo.getProductFolderOption().equals("MPCinematic"))
            {
                MPCinematic MPCinematic = new MPCinematic();
                MPCinematic.setMovie(bulkdataInfo.getMovie());
                MPCinematicService.deleteMPCinematicBasedOnMovie(MPCinematic.getMovie());

            }
            if(bulkdataInfo.getProductFolderOption().equals("MPPaper"))
            {
                MPPaper MPPaper = new MPPaper();
                MPPaper.setMovie(bulkdataInfo.getMovie());
                MPPaperService.deleteMPPaperBasedOnMovie(MPPaper.getMovie());
            }
            return "Success";
        }catch (Exception e)
        {
            return e.getMessage();
        }

    }
}

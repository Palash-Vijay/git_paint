package com.pied.piper.core.services.interfaces;

import com.pied.piper.core.db.model.Image;
import com.pied.piper.core.dto.ImageMetaData;
import com.pied.piper.core.dto.ProfileDetails;
import com.pied.piper.core.dto.SaveImageRequestDto;
import com.pied.piper.core.dto.SearchResponseDto;

import java.util.List;

/**
 * Created by akshay.kesarwan on 21/05/16.
 */
public interface GalleriaService {
    Long saveImage(SaveImageRequestDto saveImageRequestDto) throws Exception;
    String getImageData(Long imageId);
    ImageMetaData getImageMetaData(Long imageId);
<<<<<<< ab6274f1394ed39c97dbde2066f18b3570cc54d4
    List<ImageMetaData> getImageMetaData(String accountId);
    List<Image> findByAccountId(String accountId);
=======

    Image getImage(String accountId);

>>>>>>> Search Image
    Image getImage(Long imageId);
    SearchResponseDto search(String searchText);
    ProfileDetails getProfileDetails(String accountId) throws Exception;
}

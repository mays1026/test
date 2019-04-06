package org.fh.shop.admin.mays.dao.product;

import org.fh.shop.admin.mays.model.images.ImagesInfo;

import java.util.List;

public interface IImagesDao {
    void addImages(List<ImagesInfo> list);

    List<ImagesInfo> findImagesList(Integer id);

    void deleteImages(List<Integer> list);

    List<ImagesInfo> findImagesPathByImageIds(List<Integer> list);
}

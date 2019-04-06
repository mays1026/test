package org.fh.shop.admin.mays.service.product;

import org.fh.shop.admin.mays.dao.product.IImagesDao;
import org.fh.shop.admin.mays.model.images.ImagesInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类名: IImagesServiceImpl
 * 描述：
 *
 * @author
 * @create 2019-02-17 21:00
 **/
@Service
public class IImagesServiceImpl implements IImagesService {

    @Autowired
    private IImagesDao imagesDao;

    @Override
    public void addImages(List<ImagesInfo> list) {
        imagesDao.addImages(list);
    }

    @Override
    public List<ImagesInfo> findImagesList(Integer id) {
        return imagesDao.findImagesList(id);
    }

    @Override
    public void deleteImages(List<Integer> list) {
        imagesDao.deleteImages(list);
    }

    @Override
    public List<ImagesInfo> findImagesPathByImageIds(List<Integer> list) {
        return imagesDao.findImagesPathByImageIds(list);
    }
}

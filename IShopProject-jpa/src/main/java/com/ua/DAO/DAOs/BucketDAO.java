package com.ua.DAO.DAOs;

import com.ua.Model.Bucket;
import com.ua.Model.User;
import com.ua.Shared.AbstractCRUD;

public interface BucketDAO extends AbstractCRUD<Bucket> {
	void delete(String id);

	Bucket read(String id);
}

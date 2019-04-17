package com.ua.Service;

import com.ua.Model.Bucket;
import com.ua.Shared.AbstractCRUD;

public interface BucketService extends AbstractCRUD<Bucket> {
	void delete(String id);

	Bucket read(String id);
}

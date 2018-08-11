package com.brynachj.retro.notes.service.notes;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by brynach on 11/08/2018.
 */
@Repository
public interface NoteRepository extends MongoRepository<Note, Integer>{

}

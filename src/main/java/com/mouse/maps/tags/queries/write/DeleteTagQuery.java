package com.mouse.maps.tags.queries.write;

import com.mouse.maps.exceptions.BadRequestException;
import com.mouse.maps.tags.data.TagRepository;
import com.mouse.maps.tags.queries.DeleteTag;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteTagQuery implements DeleteTag {

    @Autowired
    protected TagRepository tagRepository;

    @Override
    public void invoke(Integer tagId) {
        val foundTag = this.tagRepository.findById(tagId);

        if (!foundTag.isPresent()) {
            throw new BadRequestException("Тег с указанным идентификатором не существует");
        }

        this.tagRepository.delete(foundTag.get());
    }
}

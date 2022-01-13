package ua.alevel.facade;

import org.springframework.web.context.request.WebRequest;
import ua.alevel.view.dto.request.StudentRequestDto;
import ua.alevel.view.dto.response.PageData;
import ua.alevel.view.dto.response.StudentResponseDto;

import java.util.List;

public interface StudentFacade extends BaseFacade<StudentRequestDto, StudentResponseDto> {

    PageData<StudentResponseDto> findByGroupId(WebRequest request, Long groupId);

    List<StudentResponseDto> findAll();
}

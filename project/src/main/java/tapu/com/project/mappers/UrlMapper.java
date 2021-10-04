package tapu.com.project.mappers;

import org.mapstruct.Mapper;
import tapu.com.project.dto.UrlDTO;
import tapu.com.project.model.Url;

@Mapper
public interface UrlMapper {

    Url mapFromUrlDTOtoUrl(UrlDTO urlDTO);
}

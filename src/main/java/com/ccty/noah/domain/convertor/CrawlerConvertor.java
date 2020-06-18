package com.ccty.noah.domain.convertor;

import com.ccty.noah.domain.database.ArticleDO;
import com.ccty.noah.domain.database.CommentDO;
import com.ccty.noah.domain.database.UserDO;
import com.ccty.noah.domain.dto.ArticleDTO;
import com.ccty.noah.domain.dto.CommentDTO;
import com.ccty.noah.domain.dto.UserDTO;
import com.ccty.noah.util.EntityFactory;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * 数据对象转换
 * @author 缄默
 * @date   2020/06/16
 */
@Mapper(componentModel = "spring", uses = EntityFactory.class)
public interface CrawlerConvertor {

    /**
     * 文章DO对象转DTO对象
     * @param articleDO
     * @return
     */
    ArticleDTO articleDoToDTOObj(ArticleDO articleDO);

    /**
     * 文章DO对象转DTO对象
     * @param articleList
     * @return
     */
    List<ArticleDTO> articleDOToDTO(List<ArticleDO> articleList);

    /**
     * 文章DTO对象转DO对象
     * @param articleDTO
     * @return
     */
    ArticleDO articleDTOToDOObj(ArticleDTO articleDTO);

    /**
     * 文章DTO对象转DO对象
     * @param articleList
     * @return
     */
    List<ArticleDO> articleDTOToDO(List<ArticleDTO> articleList);

    /**
     * 评价DTO对象转DO对象
     * @param commentDTO
     * @return
     */
    CommentDO commentDTOToDOObj(CommentDTO commentDTO);

    /**
     * 评价DTO对象转DO对象
     * @param commentList
     * @return
     */
    List<CommentDO> commentDTOToDO(List<CommentDTO> commentList);

    /**
     * 用户DTO对象转DO对象
     * @param userDTO
     * @return
     */
    UserDO userDTOToDOObj(UserDTO userDTO);

    /**
     * 用户DTO对象转DO对象
     * @param userList
     * @return
     */
    List<UserDO> userDTOToDO(List<UserDTO> userList);

    /**
     * 用户DO对象转DTO对象
     * @param userDO
     * @return
     */
    UserDTO userDOToDTOObj(UserDO userDO);

    /**
     * 用户DO对象转DTO对象
     * @param userList
     * @return
     */
    List<UserDTO> userDOToDTO(List<UserDO> userList);
}

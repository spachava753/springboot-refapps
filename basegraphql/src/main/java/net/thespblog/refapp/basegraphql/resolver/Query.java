package net.thespblog.refapp.basegraphql.resolver;


import graphql.kickstart.tools.GraphQLQueryResolver;
import net.thespblog.refapp.basegraphql.model.Post;
import org.springframework.stereotype.Component;

@Component
class Query implements GraphQLQueryResolver {

    Post getPost(Long id) {
        return new Post(id);
    }

    Post getComment(Long id) {
        return new Post(id);
    }

}
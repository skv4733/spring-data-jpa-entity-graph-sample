package com.cosium.spring_data_jpa_entity_graph_sample;

import com.cosium.spring.data.jpa.entity.graph.domain2.DynamicEntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraph;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraphQueryHint;
import com.cosium.spring.data.jpa.entity.graph.domain2.EntityGraphType;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

public class ProductEntityGraph implements EntityGraph {
  private final EntityGraph delegate;

  private ProductEntityGraph(RootComposer rootComposer) {
    EntityGraphType type = rootComposer.entityGraphType;
    List<String> attributePaths = rootComposer.entityGraphAttributePaths.stream().map(pathParts -> String.join(".", pathParts)).collect(Collectors.toList());
    this.delegate = new DynamicEntityGraph(type, attributePaths);
  }

  public static RootComposer ____() {
    return new RootComposer();
  }

  public static RootComposer ____(EntityGraphType entityGraphType) {
    return new RootComposer(entityGraphType);
  }

  @Override
  public Optional<EntityGraphQueryHint> buildQueryHint(EntityManager entityManager,
      Class<?> entityType) {
    return delegate.buildQueryHint(entityManager, entityType);
  }

  public static class RootComposer {
    private final EntityGraphType entityGraphType;

    private final List<List<String>> entityGraphAttributePaths;

    private RootComposer() {
      this(EntityGraphType.LOAD);
    }

    private RootComposer(EntityGraphType entityGraphType) {
      this.entityGraphType = entityGraphType;
      entityGraphAttributePaths = new ArrayList<List<String>>();
    }

    public ProductEntityGraph ____() {
      return new ProductEntityGraph(this);
    }

    public BrandEntityGraph.NodeComposer<RootComposer> brand() {
      List<String> path = new ArrayList<String>();
      path.add("brand");
      entityGraphAttributePaths.add(path);
      return new BrandEntityGraph.NodeComposer<RootComposer>(this, path);
    }
  }

  public static class NodeComposer<R> {
    public final R ____;

    private final List<String> path;

    public NodeComposer(R root, List<String> path) {
      this.____ = root;
      this.path = path;
    }

    public BrandEntityGraph.NodeComposer<R> brand() {
      path.add("brand");
      return new BrandEntityGraph.NodeComposer<R>(____, path);
    }
  }
}

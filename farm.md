graph TD
    %% 泳道分区
    subgraph 用户（前端）
        A[发起操作请求] --> B[选择操作类型<br>（查询/新增/更新/删除）]
    end
    subgraph 系统（后端服务）
        B --> C{操作类型}
        C -->|查询| D[调用服务层<br>getAnalysis()]
        C -->|新增| E[调用服务层<br>addAnalysis()]
        C -->|更新| F[调用服务层<br>updateAnalysis()]
        C -->|删除| G[调用服务层<br>deleteAnalysis()]
        
        %% 查询路径
        D --> H[持久层查询数据库]
        H --> I{查询结果}
        I -->|存在数据| J[返回200 OK<br>（数据列表）]
        I -->|无数据| K[返回200 OK<br>（空列表）]
        
        %% 新增路径
        E --> L[数据校验<br>（必填字段、格式）]
        L -->|通过| M[持久层插入数据]
        L -->|失败| N[返回400 Bad Request]
        M -->|成功| O[返回201 Created<br>（记录ID）]
        
        %% 更新路径
        F --> P[检查记录ID存在性]
        P -->|存在| Q[持久层更新数据]
        P -->|不存在| R[返回404 Not Found]
        Q --> S{影响行数}
        S -->|>0| T[返回200 OK]
        S -->|=0| U[返回404 Not Found]
        
        %% 删除路径
        G --> V[持久层删除数据]
        V --> W{影响行数}
        W -->|>0| X[返回200 OK]
        W -->|=0| Y[返回404 Not Found]
    end

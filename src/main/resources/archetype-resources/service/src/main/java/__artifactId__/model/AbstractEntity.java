#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/*
 * Copyright 2016 Randy Nott
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ${package}.${artifactId}.model;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Entity base class providing create and update timestamp functionality.
 */
@MappedSuperclass
@Access(AccessType.FIELD)
public class AbstractEntity {

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED")
    private Date createDate;

    @Column(name = "CREATED_BY", length = 64)
    private String createdBy;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATED")
    private Date updateDate;

    @Column(name = "LAST_UPDATED_BY", length = 64)
    private String updatedBy;

    @PrePersist
    void insert() {
        createDate = Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault() ).toInstant() );
        updateDate = createDate;
        updatedBy = createdBy;
    }

    @PreUpdate
    void update() {
        updateDate = Date.from( LocalDateTime.now().atZone( ZoneId.systemDefault() ).toInstant() );
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy( String createdBy ) {
    	this.createdBy = createdBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy( String updatedBy ) {
    	this.updatedBy = updatedBy;
    }
}

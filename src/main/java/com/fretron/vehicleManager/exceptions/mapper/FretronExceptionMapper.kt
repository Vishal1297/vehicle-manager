package com.fretron.vehicleManager.exceptions.mapper

import com.fretron.vehicleManager.exceptions.FretronException
import com.fretron.vehicleManager.exceptions.MappingException
import com.fretron.vehicleManager.exceptions.MongoDbException
import com.fretron.vehicleManager.exceptions.ResourceNotFoundException
import com.fretron.vehicleManager.model.ErrorResponse
import org.codehaus.jackson.map.ObjectMapper
import java.time.LocalDateTime
import javax.inject.Inject
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class FretronExceptionMapper @Inject constructor(
    private val objectMapper: ObjectMapper
) : ExceptionMapper<FretronException> {


    @Produces(MediaType.APPLICATION_JSON)
    override fun toResponse(exception: FretronException?): Response {

        when (exception) {
            is MappingException -> {
                return Response.ok().entity(
                    objectMapper.writeValueAsString(
                        ErrorResponse(
                            "400", exception.message,
                            LocalDateTime.now().toString(), exception.toString()
                        )
                    )
                ).build()
            }
            is com.fretron.vehicleManager.exceptions.NotAllowedException -> {
                return Response.ok().entity(
                    objectMapper.writeValueAsString(
                        ErrorResponse(
                            "400",
                            exception.message,
                            LocalDateTime.now().toString(),
                            exception.toString()
                        )
                    )
                ).build()
            }
            is MongoDbException -> {
                return Response.ok().entity(
                    objectMapper.writeValueAsString(
                        ErrorResponse(
                            "400",
                            exception.message,
                            LocalDateTime.now().toString(),
                            exception.toString()
                        )
                    )
                ).build()
            }
            is ResourceNotFoundException -> {
                return Response.ok().entity(
                    objectMapper.writeValueAsString(
                        ErrorResponse(
                            "404",
                            exception.message.toString(),
                            LocalDateTime.now().toString(),
                            exception.toString()
                        )
                    )
                ).build()
            }

        }
        return Response.ok().entity("Some error has occurred : ${exception?.message}").build()
    }
}
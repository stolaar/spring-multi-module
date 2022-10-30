package com.example.stolaar.api.controller

import com.example.stolaar.api.ApiApplication
import com.example.stolaar.application.request.CreateCompanyRequestDTO
import com.example.stolaar.application.request.UpdateCompanyRequestDTO
import com.example.stolaar.application.response.CompanyResponseDTO
import com.example.stolaar.application.usecase.*
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("${ApiApplication.V1}/Companies", produces = [MediaType.APPLICATION_JSON_VALUE])
@Tag(name = "Companies")
class CompanyController(
    private val getAllCompanyUseCase: GetAllCompanyUseCase,
    private val getOneCompanyUseCase: GetOneCompanyUseCase,
    private val createCompanyUseCase: CreateCompanyUseCase,
    private val updateCompanyUseCase: UpdateCompanyUseCase,
    private val deleteCompanyUseCase: DeleteCompanyUseCase
) {

    @Operation(description = "Endpoint to list all Companies")
    @ResponseBody
    @ApiResponses(
        value = [
        ApiResponse(responseCode = "200", description = "List of Companies was returned with success"),
        ]
    )
    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    fun index(pageable: Pageable) : ResponseEntity<Page<CompanyResponseDTO>> {
        return ResponseEntity.ok(getAllCompanyUseCase.execute(pageable))
    }

    @Operation(description = "Endpoint to get a Company by id")
    @ResponseBody
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Unique Company was returned with success"),
            ApiResponse(responseCode = "404", description = "Company not found"),
        ]
    )
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    fun detail(@PathVariable id: String): ResponseEntity<CompanyResponseDTO> {
        return ResponseEntity.ok(getOneCompanyUseCase.execute(id))
    }

    @Operation(description = "Endpoint to create a new Company")
    @ResponseBody
    @ApiResponses(
        value = [
        ApiResponse(responseCode = "200", description = "List of Companies was returned with success"),
        ]
    )
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun store(@RequestBody createCompanyRequestDTO: CreateCompanyRequestDTO, uriComponentsBuilder: UriComponentsBuilder): ResponseEntity<CompanyResponseDTO> {
        val createdCompany = createCompanyUseCase.execute(createCompanyRequestDTO)
        val uriComponents = uriComponentsBuilder.path("/{id}").buildAndExpand(createdCompany.id)
        return ResponseEntity.created(uriComponents.toUri()).body(createdCompany)
    }

    @Operation(description = "Endpoint to update a Company")
    @ResponseBody
    @ApiResponses(
        value = [
        ApiResponse(responseCode = "200", description = "List of Companies was returned with success"),
        ]
    )
    @PatchMapping
    @ResponseStatus(value = HttpStatus.OK)
    fun update(@RequestBody updateCompanyRequestDTO: UpdateCompanyRequestDTO): ResponseEntity<CompanyResponseDTO> {
        return ResponseEntity.ok(updateCompanyUseCase.execute(updateCompanyRequestDTO))
    }

    @Operation(description = "Endpoint to delete a Company by id")
    @ResponseBody
    @ApiResponses(
        value = [
        ApiResponse(responseCode = "200", description = "List of Companies was returned with success"),
            ApiResponse(responseCode = "404", description = "Company not found"),
        ]
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun destroy(@PathVariable id: String) {
        deleteCompanyUseCase.execute(id)
    }

}
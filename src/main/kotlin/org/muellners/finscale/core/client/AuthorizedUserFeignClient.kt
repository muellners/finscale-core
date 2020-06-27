package org.muellners.finscale.core.client

import kotlin.reflect.KClass
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.FeignClientsConfiguration
import org.springframework.core.annotation.AliasFor

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@MustBeDocumented
@FeignClient
annotation class AuthorizedUserFeignClient(

    @get:AliasFor(annotation = FeignClient::class, attribute = "name")
    val name: String = "",

    /**
     * A custom {@code @Configuration} for the feign client.
     *
     * Can contain override `@Bean` definition for the pieces that make up the client, for instance [feign.codec.Decoder],
     * [feign.codec.Encoder], [feign.Contract].
     *
     * @see FeignClientsConfiguration for the defaults.
     */
    @get:AliasFor(annotation = FeignClient::class, attribute = "configuration")
    val configuration: Array<KClass<*>> = [OAuth2UserClientFeignConfiguration::class],

    /**
     * An absolute URL or resolvable hostname (the protocol is optional).
     */
    val url: String = "",

    /**
     * Whether 404s should be decoded instead of throwing FeignExceptions.
     */
    val decode404: Boolean = false,

    /**
     * Fallback class for the specified Feign client interface. The fallback class must implement the interface
     * annotated by this annotation and be a valid Spring bean.
     */
    val fallback: KClass<*> = Unit::class,

    /**
     * Path prefix to be used by all method-level mappings. Can be used with or without `@RibbonClient`.
     */
    val path: String = ""
)

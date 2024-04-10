package joliex.util.types;

import jolie.runtime.Value;
import jolie.runtime.ValueVector;
import jolie.runtime.ByteArray;
import jolie.runtime.typing.TypeCheckingException;

import java.util.ArrayList;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.List;
import java.util.Optional;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import joliex.java.embedding.*;
import joliex.java.embedding.JolieNative.*;
import joliex.java.embedding.util.*;

/**
 * this class is an {@link ImmutableStructure} which can be described as follows:
 * 
 * <pre>
 * content: {@link Void}
 *     month: {@link Integer}
 *     hour: {@link Integer}
 *     year: {@link Integer}
 *     day: {@link Integer}
 *     second: {@link Integer}
 *     minute: {@link Integer}
 * </pre>
 * 
 * @see JolieValue
 * @see JolieNative
 * @see #construct()
 */
public final class DateTimeType extends ImmutableStructure<JolieVoid> {
    
    public Integer month() { return getFirstChildValue( "month", JolieInt.class ).get(); }
    public Integer hour() { return getFirstChildValue( "hour", JolieInt.class ).get(); }
    public Integer year() { return getFirstChildValue( "year", JolieInt.class ).get(); }
    public Integer day() { return getFirstChildValue( "day", JolieInt.class ).get(); }
    public Integer second() { return getFirstChildValue( "second", JolieInt.class ).get(); }
    public Integer minute() { return getFirstChildValue( "minute", JolieInt.class ).get(); }
    
    private DateTimeType( Builder<?> builder ) {
        super( builder.content(), builder.children() );
    }
    
    public static InlineBuilder construct() { return new InlineBuilder(); }
    
    static <T> NestedBuilder<T> constructNested( Function<DateTimeType, T> doneFunc ) { return new NestedBuilder<>( doneFunc ); }
    static <T> NestedBuilder<T> constructNested( Function<DateTimeType, T> doneFunc, JolieValue t ) { return new NestedBuilder<>( doneFunc, t ); }
    
    static InlineListBuilder constructList() { return new InlineListBuilder(); }
    
    static <T> NestedListBuilder<T> constructNestedList( Function<List<DateTimeType>, T> doneFunc ) { return new NestedListBuilder<>( doneFunc ); }
    static <T> NestedListBuilder<T> constructNestedList( Function<List<DateTimeType>, T> doneFunc, SequencedCollection<? extends JolieValue> c ) { return new NestedListBuilder<>( doneFunc, c ); }
    
    public static InlineBuilder constructFrom( JolieValue t ) { return new InlineBuilder( t ); }
    
    public static DateTimeType createFrom( JolieValue t ) throws TypeValidationException { return constructFrom( t ).build(); }
    
    public static Value toValue( DateTimeType t ) { return JolieValue.toValue( t ); }
    public static DateTimeType fromValue( Value value ) throws TypeCheckingException { return Builder.buildFrom( value ); }
    
    static abstract class Builder<B> extends StructureBuilder<JolieVoid, B> {
        
        private static final Map<String,FieldManager<?>> FIELD_MAP = Map.of(
            "month", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom ),
            "hour", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom ),
            "year", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom ),
            "day", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom ),
            "second", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom ),
            "minute", FieldManager.createNative( JolieInt::fromValue, JolieInt::createFrom )
        );
        
        protected Builder() {}
        protected Builder( JolieValue structure ) {
            super(
                null,
                structure.children()
                    .entrySet()
                    .parallelStream()
                    .filter( e -> FIELD_MAP.containsKey( e.getKey() ) )
                    .collect( Collectors.toConcurrentMap(
                        Map.Entry::getKey,
                        e -> FIELD_MAP.get( e.getKey() ).fromJolieValues( e.getValue() )
                    ) )
            );
        }
        
        private JolieVoid content() { return JolieNative.create(); }
        private Map<String, List<JolieValue>> children() { return children; }
        
        public B setMonth( JolieInt contentEntry ) { return putAs( "month", contentEntry, JolieValue::create ); }
        public B setMonth( Integer valueEntry ) { return putAs( "month", valueEntry, JolieValue::create ); }
        public B replaceMonth( UnaryOperator<Integer> valueOperator ) { return computeAs( "month", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        public B setHour( JolieInt contentEntry ) { return putAs( "hour", contentEntry, JolieValue::create ); }
        public B setHour( Integer valueEntry ) { return putAs( "hour", valueEntry, JolieValue::create ); }
        public B replaceHour( UnaryOperator<Integer> valueOperator ) { return computeAs( "hour", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        public B setYear( JolieInt contentEntry ) { return putAs( "year", contentEntry, JolieValue::create ); }
        public B setYear( Integer valueEntry ) { return putAs( "year", valueEntry, JolieValue::create ); }
        public B replaceYear( UnaryOperator<Integer> valueOperator ) { return computeAs( "year", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        public B setDay( JolieInt contentEntry ) { return putAs( "day", contentEntry, JolieValue::create ); }
        public B setDay( Integer valueEntry ) { return putAs( "day", valueEntry, JolieValue::create ); }
        public B replaceDay( UnaryOperator<Integer> valueOperator ) { return computeAs( "day", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        public B setSecond( JolieInt contentEntry ) { return putAs( "second", contentEntry, JolieValue::create ); }
        public B setSecond( Integer valueEntry ) { return putAs( "second", valueEntry, JolieValue::create ); }
        public B replaceSecond( UnaryOperator<Integer> valueOperator ) { return computeAs( "second", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        public B setMinute( JolieInt contentEntry ) { return putAs( "minute", contentEntry, JolieValue::create ); }
        public B setMinute( Integer valueEntry ) { return putAs( "minute", valueEntry, JolieValue::create ); }
        public B replaceMinute( UnaryOperator<Integer> valueOperator ) { return computeAs( "minute", (n,v) -> valueOperator.apply( v ), s -> JolieInt.class.cast( s.content() ).value(), JolieValue::create ); }
        
        protected DateTimeType validatedBuild() throws TypeValidationException {
            validateChildren( FIELD_MAP );
            
            return new DateTimeType( this );
        }
        
        private static DateTimeType buildFrom( Value value ) throws TypeCheckingException {
            InlineBuilder builder = DateTimeType.construct();
            
            builder.content( JolieVoid.fromValue( value ) );
            
            for ( Map.Entry<String, ValueVector> child : value.children().entrySet() ) {
                if ( !FIELD_MAP.containsKey( child.getKey() ) )
                    throw new TypeCheckingException( "Unexpected field was set, field \"" + child.getKey() + "\"." );
                
                builder.put( child.getKey(), FIELD_MAP.get( child.getKey() ).fromValueVector( child.getValue() ) );
            }
            
            try {
                return builder.build();
            } catch ( TypeValidationException e ) {
                throw new TypeCheckingException( e.getMessage() );
            }
        }
    }
    
    public static class InlineBuilder extends Builder<InlineBuilder> {
        
        private InlineBuilder() {}
        private InlineBuilder( JolieValue t ) { super( t ); }
        
        protected InlineBuilder self() { return this; }
        
        public DateTimeType build() throws TypeValidationException { return validatedBuild(); }
    }
    
    public static class NestedBuilder<T> extends Builder<NestedBuilder<T>> {
        
        private final Function<DateTimeType, T> doneFunc;
        
        private NestedBuilder( Function<DateTimeType, T> doneFunc, JolieValue t ) { super( t ); this.doneFunc = doneFunc; }
        private NestedBuilder( Function<DateTimeType, T> doneFunc ) { this.doneFunc = doneFunc; }
        
        protected NestedBuilder<T> self() { return this; }
        
        public T done() throws TypeValidationException { return doneFunc.apply( validatedBuild() ); }
    }
    
    static abstract class ListBuilder<B> extends StructureListBuilder<DateTimeType, B> {
        
        protected ListBuilder( SequencedCollection<? extends JolieValue> elements ) { super( elements.parallelStream().map( DateTimeType::createFrom ).toList() ); }
        protected ListBuilder() {}
        
        public NestedBuilder<B> addConstructed() { return constructNested( this::add ); }
        public NestedBuilder<B> setConstructed( int index ) { return constructNested( e -> set( index, e ) ); }
        public NestedBuilder<B> addConstructedFrom( JolieValue t ) { return constructNested( this::add, t ); }
        public NestedBuilder<B> setConstructedFrom( int index, JolieValue t ) { return constructNested( e -> set( index, e ), t ); }
        public NestedBuilder<B> reconstruct( int index ) { return setConstructedFrom( index, elements.get( index ) ); }
    }
    
    public static class InlineListBuilder extends ListBuilder<InlineListBuilder> {
        
        protected InlineListBuilder self() { return this; }
        
        public List<DateTimeType> build() { return super.build(); }
    }
    
    public static class NestedListBuilder<T> extends ListBuilder<NestedListBuilder<T>> {
        
        private final Function<List<DateTimeType>, T> doneFunc;
        
        private NestedListBuilder( Function<List<DateTimeType>, T> doneFunc, SequencedCollection<? extends JolieValue> c ) { super( c ); this.doneFunc = doneFunc; }
        private NestedListBuilder( Function<List<DateTimeType>, T> doneFunc ) { this.doneFunc = doneFunc; }
        
        protected NestedListBuilder<T> self() { return this; }
        
        public T done() throws TypeValidationException { return doneFunc.apply( build() ); }
    }
}
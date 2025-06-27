# Entity Mappers Documentation

This project includes two different approaches for mapping between JPA entities and domain objects:

## 1. MapStruct Mappers (Recommended for new development)

MapStruct mappers are located in the `carlos.silva.ingressos.persistence.mappers.mapstruct` package.

### Features:
- **Compile-time code generation** - Better performance and type safety
- **Spring integration** - Automatically registered as Spring beans
- **Annotation-based configuration** - Clean and declarative mapping definitions

### Available MapStruct Mappers:

#### UserMapperMapStruct
```java
@Autowired
private UserMapperMapStruct userMapper;

// Domain to Entity
UserEntity entity = userMapper.fromDomain(user);

// Entity to Domain
User user = userMapper.toDomain(userEntity);
```

#### EventMapperMapStruct
```java
@Autowired
private EventMapperMapStruct eventMapper;

// Domain to Entity
EventEntity entity = eventMapper.fromDomain(event);

// Entity to Domain
Event event = eventMapper.toDomain(eventEntity);
```

#### TicketMapperMapStruct
```java
@Autowired
private TicketMapperMapStruct ticketMapper;

// Domain to Entity
TicketEntity entity = ticketMapper.fromDomain(ticket);

// Entity to Domain (full mapping)
Ticket ticket = ticketMapper.toDomain(ticketEntity);
```

**Note:** The TicketMapperMapStruct now supports full mapping in both directions thanks to the improved Ticket domain model constructor.

## 2. Manual Mappers (Traditional approach)

Manual mappers are located in the `carlos.silva.ingressos.persistence.mappers.manual` package.

### Features:
- **Full control** over mapping logic
- **Handles complex scenarios** - Can work around domain model limitations
- **Runtime flexibility** - Can include conditional logic and validation

### Available Manual Mappers:

#### UserMapperManual
```java
@Autowired
private UserMapperManual userMapper;

// Domain to Entity
UserEntity entity = userMapper.fromDomain(user);

// Entity to Domain
User user = userMapper.toDomain(userEntity);
```

#### EventMapperManual
```java
@Autowired
private EventMapperManual eventMapper;

// Domain to Entity
EventEntity entity = eventMapper.fromDomain(event);

// Entity to Domain
Event event = eventMapper.toDomain(eventEntity);
```

#### TicketMapperManual
```java
@Autowired
private TicketMapperManual ticketMapper;

// Domain to Entity
TicketEntity entity = ticketMapper.fromDomain(ticket);

// Entity to Domain (full mapping with proper constructor)
Ticket ticket = ticketMapper.toDomain(ticketEntity);
```

**Note:** The TicketMapperManual now uses the proper Ticket constructor instead of reflection.

## Migration from Entity Methods

The original `fromDomain` and `toDomain` methods have been removed from the entity classes:
- `UserEntity.fromDomain()` and `UserEntity.toDomain()` → Use `UserMapperMapStruct` or `UserMapperManual`
- `EventEntity.fromDomain()` and `EventEntity.toDomain()` → Use `EventMapperMapStruct` or `EventMapperManual`
- `TicketEntity.fromDomain()` → Use `TicketMapperMapStruct` or `TicketMapperManual`

## Recommendations

1. **For new development**: Use MapStruct mappers for better performance and maintainability
2. **For all entity mapping**: Both MapStruct and manual mappers now support full mapping capabilities
3. **Performance**: MapStruct mappers are recommended for better compile-time optimization

## Domain Model Improvements ✅

The Ticket domain class has been improved and now supports full mapping:
- ✅ Complete constructor accepting all fields (id, eventId, price, userId, selledAt)
- ✅ All mappers can now perform full bidirectional mapping
- ✅ No need for reflection or workarounds

The updated constructor signature:
```java
public Ticket(TicketId id, EventId eventId, int price, UserId userId, Instant selledAt)
```

This allows both MapStruct and manual mappers to work efficiently and safely.

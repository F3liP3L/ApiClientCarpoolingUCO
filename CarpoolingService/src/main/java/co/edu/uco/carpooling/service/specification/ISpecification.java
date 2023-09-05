package co.edu.uco.carpooling.service.specification;

public interface ISpecification<T> {
    public boolean isSatisfyBy(T object);
    public ISpecification<T> and(ISpecification<T> other);
    public ISpecification<T> or(ISpecification<T> other);
    public ISpecification<T> not(ISpecification<T> other);
    public ISpecification<T> andNot(ISpecification<T> other);
    public ISpecification<T> orNot(ISpecification<T> other);

}

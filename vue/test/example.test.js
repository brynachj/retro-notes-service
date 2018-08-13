import Example from "../Example"

describe("Example", () => {
  it("should be instanceable", () => {
    expect(new Example()).toBeInstanceOf(Example)
  })
})

describe("add", () => {
  it("should add two numbers", () => {
    const example = new Example()
    expect(example.add(1,2)).toBe(3)
  })
})

describe("multiply", () => {
  it("should multiply two numbers", () => {
    const example = new Example()
    expect(example.multiply(3,4)).toBe(12)
  })
})

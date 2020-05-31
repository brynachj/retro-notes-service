import { shallowMount } from '@vue/test-utils'
import HelloWorld from '@/components/NotesTitle.vue'

describe('NotesTitle test my man', () => {
  it('renders props.msg when passed', () => {
    const msg = 'new message'
    const wrapper = shallowMount(HelloWorld, {
      propsData: { msg }
    })
    
    expect(wrapper.find('.hello h1').exists()).toBe(true)
    expect(wrapper.find('.hello h1').text()).toMatch(msg)
  });
})

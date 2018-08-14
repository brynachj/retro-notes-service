import { shallowMount } from '@vue/test-utils';
import Note from '@/components/Note.vue';

describe('Note', () => {
    it('creates an element with an id of note', () => {
        const wrapper = shallowMount(Note);

        expect(wrapper.find('.note').exists()).toBe(true);
    })

    it('takes note as input and displays a title', () => {
        const note = {
            title: "our note"
        };

        const wrapper = shallowMount(Note, {
            propsData: {note}
        });

        expect(wrapper.find('.note h1').exists()).toBe(true);
        expect(wrapper.find('.note h1').text()).toMatch('our note');
    })
    it('takes note as input and displays a message', () => {
        const note = {
            title: "our note",
            content: "This is our retro note."
        };

        const wrapper = shallowMount(Note, {
            propsData: {note}
        });

        expect(wrapper.find('.note p').exists()).toBe(true);
        expect(wrapper.find('.note p').text()).toMatch('This is our retro note.');
    })

    it('returns error text when nothing passed in', () => {
        const wrapper = shallowMount(Note);

        expect(wrapper.find('.note p').exists()).toBe(true);
        expect(wrapper.find('.note p').text()).toMatch('error, no content');

        expect(wrapper.find('.note h1').exists()).toBe(true);
        expect(wrapper.find('.note h1').text()).toMatch('error, no title');
    })
})
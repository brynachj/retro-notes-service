import { shallowMount, mount } from '@vue/test-utils'
import App from '@/App.vue'
import NotesDisplay from '@/components/NotesDisplay.vue'
import axios from 'axios';

describe('App', () => {
    it('is created correctly', () => {
        const wrapper = shallowMount(App)

        expect(wrapper.find('#app').exists()).toBe(true);
    });

    it('passes an empty array to notesdisplay', () => {
        const wrapper = mount(App)

        const note = []

        // expect the NotesDisplay to contain Notes reponse
        const noteDisplay = wrapper.find(NotesDisplay);

        expect(noteDisplay.props().notes).toEqual(note)
    })

    it('obtains data from the API and passes to notesdisplay correctly', () => {
        
        const note = [{"title":"title1", "content":"content1"}]

        axios.get = jest.fn((url) => {
            return Promise.resolve({data: note})
        })
        const wrapper = mount(App)

        // expect the NotesDisplay to contain Notes reponse
        const noteDisplay = wrapper.find(NotesDisplay);
        wrapper.vm.$nextTick(function () {
            expect(noteDisplay.props().notes).toEqual(note);
        })
    })
});